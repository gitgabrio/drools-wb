/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
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

package org.drools.workbench.screens.scenariosimulation.client.resources.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

/**
 * ScenarioSimulationEditor I18N constants
 */
public interface ScenarioSimulationEditorConstants
        extends
        Messages {

    ScenarioSimulationEditorConstants INSTANCE = GWT.create(ScenarioSimulationEditorConstants.class);

    String newScenarioSimulationDescription();

    String factColumnHeader();

    String fieldColumnHeader();

    String contextColumnHeader();

    String addScenarioSimulation();

    String scenarioSimulationEditorTitle();

    String scenarioSimulationResourceTypeDescription();

    String remove();

    String invalidDefinitionDisabled();

    String showRightPanel();

    String hideRightPanel();

    String testTools();

    String testEditor();

    String scenarioCheatSheet();

    String runScenarioSimulation();

    String expected();

    String insertColumnLeft();

    String insertColumnRight();

    String deleteColumn();

    String insertRowBelow();

    String scenario();

    String given();

    String insertRowAbove();

    String deleteRow();

    String duplicateRow();

    String prependRow();

    String appendRow();

    String insertLeftmostColumn();

    String insertRightmostColumn();

    String description();
}
