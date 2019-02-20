package ua.mateacademy.tania.patterns.adapter;

/**
 * Created by Таня on 06.08.2018.
 */
public class AdapterPatternApp {
    public static void main(String[] args) {
        DVIConnector dviConnector = new DVIConnectorAdapterToSVGA();
        dviConnector.connectDVI();
    }
}
