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
package org.drools.workbench.screens.scenariosimulation.backend.server.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.drools.scenariosimulation.api.model.ScenarioSimulationModel;
import org.drools.scenariosimulation.api.model.Simulation;
import org.uberfire.backend.vfs.Path;

@ApplicationScoped
public class ScenarioSimulationBuilder {

    @Inject
    protected RULESimulationCreationStrategy ruleSimulationCreationStrategy;

    @Inject
    protected DMNSimulationCreationStrategy dmnSimulationCreationStrategy;

    public Simulation createSimulation(Path context, ScenarioSimulationModel.Type type, String value) throws Exception {
        switch (type) {
            case RULE:
                return ruleSimulationCreationStrategy.createSimulation(context, value);
            case DMN:
                return dmnSimulationCreationStrategy.createSimulation(context, value);
            default:
                return null;
        }
    }
}
