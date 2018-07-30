package com.dlsc.workbenchfx.view;

import com.dlsc.workbenchfx.model.WorkbenchModule;
import com.dlsc.workbenchfx.view.controls.ToolbarControl;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Displays the content of the currently active {@link Module}.
 *
 * @author François Martin
 * @author Marco Sanfratello
 */
public class ContentView extends BorderPane implements View {

  private static final Logger LOGGER = LogManager.getLogger(ContentView.class.getName());
  ToolbarControl toolbarControl;
  AddModuleView addModuleView;

  /**
   * Creates a new {@link ContentView}.
   */
  public ContentView(AddModuleView addModuleView) {
    this.addModuleView = addModuleView;
    init();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initializeSelf() {
    setId("content-view");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initializeParts() {
    toolbarControl = new ToolbarControl();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void layoutParts() {

  }

  /**
   * Replaces the current displayed Node with a new one. This is called when a new module is
   * selected and displayed.
   *
   * @param node the module content as a Node
   */
  public void setContent(Node node) {
    setCenter(node);
  }

  void addToolbar() {
    setTop(toolbarControl);
  }

  void removeToolbar() {
    setTop(null);
  }

  void setAddModuleView() {
    setCenter(addModuleView);
  }

  void setModuleInToolbar(WorkbenchModule workbenchModule) {
    toolbarControl.setModule(workbenchModule);
  }

  BooleanProperty toolbarEmptyProperty() {
    return toolbarControl.emptyProperty();
  }
}
