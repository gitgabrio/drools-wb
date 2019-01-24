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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(GwtMockitoTestRunner.class)
public class ItemEditingBoxImplTest {

    @Mock
    private ItemEditingBox.Presenter presenterMock;

    private ItemEditingBoxImpl itemEditingBoxImpl;

    @Before
    public void setup() {
        this.itemEditingBoxImpl = spy(new ItemEditingBoxImpl() {
            {
                this.presenter = presenterMock;
            }
        });
    }

    @Test
    public void onSaveItemClickEvent() {
        ClickEvent clickEventMock = mock(ClickEvent.class);
        itemEditingBoxImpl.onSaveItemClickEvent(clickEventMock);
        verify(presenterMock, times(1)).save();
        verify(itemEditingBoxImpl, times(1)).close(clickEventMock);
    }

    @Test
    public void close() {
        ClickEvent clickEventMock = mock(ClickEvent.class);
        itemEditingBoxImpl.close(clickEventMock);
        verify(presenterMock, times(1)).close(itemEditingBoxImpl);
        verify(clickEventMock, times(1)).stopPropagation();
    }
}
