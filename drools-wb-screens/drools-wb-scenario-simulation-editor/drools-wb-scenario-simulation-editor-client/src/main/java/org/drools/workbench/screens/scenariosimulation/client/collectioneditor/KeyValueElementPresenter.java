/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.screens.scenariosimulation.client.collectioneditor;

import java.util.Map;
import java.util.stream.Collectors;

import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.UListElement;

public class KeyValueElementPresenter extends ElementPresenter<KeyValueElementView> implements KeyValueElementView.Presenter {

    @Override
    public LIElement getKeyValueContainer(String itemId, Map<String, String> keyPropertiesValues, Map<String, String> valuePropertiesValues) {
        final KeyValueElementView keyValueElementView = viewsProvider.getKeyValueElementView();
        keyValueElementView.init(this);
        keyValueElementView.setItemId(itemId);
        final UListElement keyContainer = keyValueElementView.getKeyContainer();
        String keyId = itemId+ "#key";
        String valueId = itemId + "#value";
        keyPropertiesValues.forEach((propertyName, propertyValue) ->
                                            keyContainer.appendChild(propertyPresenter.getPropertyFields(keyId, propertyName, propertyValue)));

        final UListElement valueContainer = keyValueElementView.getValueContainer();
        valuePropertiesValues.forEach((propertyName, propertyValue) ->
                                              valueContainer.appendChild(propertyPresenter.getPropertyFields(valueId, propertyName, propertyValue)));
        elementViewList.add(keyValueElementView);
        return keyValueElementView.getItemContainer();
    }

    @Override
    public void onToggleRowExpansion(KeyValueElementView keyValueElementView, boolean isShown) {
        CollectionEditorUtils.toggleRowExpansion(keyValueElementView.getFaAngleRight(), !isShown);
        String itemId = keyValueElementView.getItemId();
        String keyId = itemId+ "#key";
        String valueId = itemId + "#value";
        CollectionEditorUtils.toggleRowExpansion(keyValueElementView.getKeyLabel(), isShown);
        CollectionEditorUtils.toggleRowExpansion(keyValueElementView.getValueLabel(), isShown);
        propertyPresenter.onToggleRowExpansion(keyId, isShown);
        propertyPresenter.onToggleRowExpansion(valueId, isShown);
    }

    @Override
    public void onEditItem(KeyValueElementView keyValueElementView) {
        String itemId = keyValueElementView.getItemId();
        String keyId = itemId+ "#key";
        String valueId = itemId + "#value";
        propertyPresenter.editProperties(keyId);
        propertyPresenter.editProperties(valueId);
        keyValueElementView.getSaveChange().getStyle().setVisibility(Style.Visibility.VISIBLE);
    }

    @Override
    public void updateItem(KeyValueElementView keyValueElementView) {
        String itemId = keyValueElementView.getItemId();
        String keyId = itemId+ "#key";
        String valueId = itemId + "#value";
        propertyPresenter.updateProperties(keyId);
        propertyPresenter.updateProperties(valueId);
        keyValueElementView.getSaveChange().getStyle().setVisibility(Style.Visibility.HIDDEN);
    }

    @Override
    public Map<Map<String, String>, Map<String, String>> getItemsProperties() {
        return elementViewList.stream()
                .collect(Collectors.toMap(
                        keyValueElementView -> {
                            String itemId = keyValueElementView.getItemId() + "#key";
                            return propertyPresenter.getProperties(itemId);
                        },
                        keyValueElementView -> {
                            String itemId = keyValueElementView.getItemId() + "#value";
                            return propertyPresenter.getProperties(itemId);
                        }));
    }

}