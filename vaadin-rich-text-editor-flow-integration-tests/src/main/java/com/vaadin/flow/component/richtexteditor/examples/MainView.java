package com.vaadin.flow.component.richtexteditor.examples;

import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    final Div valuePanel,
              htmlValuePanel;

    public MainView() {
        valuePanel = new Div();
        valuePanel.setId("valuePanel");

        htmlValuePanel = new Div();
        htmlValuePanel.setId("htmlValuePanel");

        final RichTextEditor rte = new RichTextEditor();

        final Button setValueButton = new Button("Set value");
        setValueButton.setId("setValue");
        setValueButton.addClickListener(event -> rte.setValue("[{\"insert\":\"Foo\"}]"));

        final Button getValueButton = new Button("Get value");
        getValueButton.setId("getValue");
        getValueButton.addClickListener(event -> {
            String value = rte.getValue();
            valuePanel.setText(value);
        });

        final Button getHtmlValueButton = new Button("Get htmlValue");
        getHtmlValueButton.setId("getHtmlValue");
        getHtmlValueButton.addClickListener(event -> {
            String htmlValue = rte.getHtmlValue();
            htmlValuePanel.setText(htmlValue);
        });

        setHeight("100%");
        add(rte, setValueButton, getValueButton, getHtmlValueButton, valuePanel, htmlValuePanel);
    }
}
