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
package org.drools.workbench.screens.scenariosimulation.client.collectioneditor.editingbox;

import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class ItemEditingBoxImpl extends EditingBoxImpl<ItemEditingBox.Presenter> implements ItemEditingBox {

//    @DataField("editingBox")
//    protected LIElement editingBox = Document.get().createLIElement();
//
//    @DataField("editingBoxTitle")
//    protected HeadingElement editingBoxTitle = Document.get().createHElement(3);
//
//    @DataField("propertiesContainer")
//    protected UListElement propertiesContainer = Document.get().createULElement();
//
//    @DataField("saveItem")
//    protected ButtonElement saveItem = Document.get().createButtonElement();
//
//    @DataField("discardItem")
//    protected ButtonElement discardItem = Document.get().createButtonElement();
//
//    protected Presenter presenter;
//
//    protected String key;
//
//    @Override
//    public void init(Presenter presenter) {
//        this.presenter = presenter;
//    }
//
//    @Override
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    @Override
//    public LIElement getEditingBox() {
//        return editingBox;
//    }
//
//    @Override
//    public HeadingElement getEditingBoxTitle() {
//        return editingBoxTitle;
//    }
//
//    @Override
//    public UListElement getPropertiesContainer() {
//        return propertiesContainer;
//    }
//
//    @EventHandler("saveItem")
//    public void onSaveItemClickEvent(ClickEvent event) {
//        presenter.save();
//        close(event);
//    }
//
//    @EventHandler("discardItem")
//    public void onDiscardItemClickEvent(ClickEvent event) {
//        close(event);
//    }
//
//    protected void close(ClickEvent event) {
//        presenter.close(this);
//        event.stopPropagation();
//    }
}