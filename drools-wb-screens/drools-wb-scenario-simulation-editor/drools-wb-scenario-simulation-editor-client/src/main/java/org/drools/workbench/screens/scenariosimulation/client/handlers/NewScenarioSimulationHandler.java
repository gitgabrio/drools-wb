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

package org.drools.workbench.screens.scenariosimulation.client.handlers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import org.drools.workbench.screens.scenariosimulation.client.editor.ScenarioSimulationEditorPresenter;
import org.drools.workbench.screens.scenariosimulation.client.resources.ScenarioSimulationEditorResources;
import org.drools.workbench.screens.scenariosimulation.client.resources.i18n.ScenarioSimulationEditorConstants;
import org.drools.workbench.screens.scenariosimulation.client.type.ScenarioSimulationResourceType;
import org.drools.workbench.screens.scenariosimulation.model.ScenarioSimulationModel;
import org.drools.workbench.screens.scenariosimulation.service.ScenarioSimulationService;
import org.guvnor.common.services.project.model.Package;
import org.jboss.errai.common.client.api.Caller;
import org.kie.workbench.common.widgets.client.handlers.DefaultNewResourceHandler;
import org.kie.workbench.common.widgets.client.handlers.NewResourcePresenter;
import org.kie.workbench.common.widgets.client.handlers.NewResourceSuccessEvent;
import org.kie.workbench.common.widgets.client.resources.i18n.CommonConstants;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.ext.widgets.common.client.callbacks.HasBusyIndicatorDefaultErrorCallback;
import org.uberfire.ext.widgets.common.client.common.BusyIndicatorView;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.security.ResourceAction;
import org.uberfire.security.ResourceRef;
import org.uberfire.security.authz.AuthorizationManager;
import org.uberfire.workbench.events.NotificationEvent;
import org.uberfire.workbench.model.ActivityResourceType;
import org.uberfire.workbench.type.ResourceTypeDefinition;

/**
 * Handler for the creation of new Scenario Simulation
 */
@ApplicationScoped
public class NewScenarioSimulationHandler
        extends DefaultNewResourceHandler {

    private Caller<ScenarioSimulationService> scenarioSimulationService;

    private ScenarioSimulationResourceType resourceType;

    private final AuthorizationManager authorizationManager;
    private final SessionInfo sessionInfo;

    @Inject
    public NewScenarioSimulationHandler(final ScenarioSimulationResourceType resourceType,
                                        final BusyIndicatorView busyIndicatorView,
                                        final Event<NotificationEvent> notificationEvent,
                                        final Event<NewResourceSuccessEvent> newResourceSuccessEvent,
                                        final PlaceManager placeManager,
                                        final Caller<ScenarioSimulationService> scenarioSimulationService,
                                        final AuthorizationManager authorizationManager,
                                        final SessionInfo sessionInfo) {
        this.resourceType = resourceType;
        this.authorizationManager = authorizationManager;
        this.sessionInfo = sessionInfo;
        this.newResourceSuccessEvent = newResourceSuccessEvent;
        this.busyIndicatorView = busyIndicatorView;
        this.scenarioSimulationService = scenarioSimulationService;
        this.placeManager = placeManager;
        this.notificationEvent = notificationEvent;
    }

    @Override
    public String getDescription() {
        return ScenarioSimulationEditorConstants.INSTANCE.newScenarioSimulationDescription();
    }

    @Override
    public IsWidget getIcon() {
        return new Image(ScenarioSimulationEditorResources.INSTANCE.images().typeScenarioSimulation());
    }

    @Override
    public ResourceTypeDefinition getResourceType() {
        return resourceType;
    }

    @Override
    public boolean canCreate() {
        return authorizationManager.authorize(new ResourceRef(ScenarioSimulationEditorPresenter.IDENTIFIER,
                                                              ActivityResourceType.EDITOR),
                                              ResourceAction.READ,
                                              sessionInfo.getIdentity());
    }

    @Override
    public void create(final Package pkg,
                       final String baseFileName,
                       final NewResourcePresenter presenter) {
        busyIndicatorView.showBusyIndicator(CommonConstants.INSTANCE.Saving());
        scenarioSimulationService.call(getSuccessCallback(presenter),
                                       new HasBusyIndicatorDefaultErrorCallback(busyIndicatorView)).create(pkg.getPackageMainResourcesPath(),
                                                                                                           buildFileName(baseFileName,
                                                                                                                         resourceType),
                                                                                                           new ScenarioSimulationModel(),
                                                                                                           "");
    }
}
