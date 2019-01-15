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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;

import com.google.gwt.dom.client.LIElement;
import org.drools.workbench.screens.scenariosimulation.client.utils.ViewsProvider;

public class ListEditorElementPresenter implements ListEditorElementView.Presenter {

    @Inject
    protected PropertyEditorPresenter propertyEditorPresenter;

    @Inject
    protected ViewsProvider viewsProvider;

    @Override
    public List<LIElement> getProperties(Map<String, String> propertiesMap, String nodeId) {
        final List<LIElement> toReturn = new ArrayList<>();
        final LIElement itemSeparator = viewsProvider.getListEditorElementView().getItemSeparator();
        itemSeparator.setAttribute("data-nodeid", nodeId);
        toReturn.add(itemSeparator);
        AtomicInteger counter = new AtomicInteger(0);
        propertiesMap.forEach((propertyName, propertyValue) ->
                                      toReturn.add(propertyEditorPresenter.getPropertyFields(propertyName, propertyValue, nodeId + "." + counter.getAndIncrement())));
        return toReturn;
    }
}