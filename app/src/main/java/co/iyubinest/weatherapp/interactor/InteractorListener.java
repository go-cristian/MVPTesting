package co.iyubinest.weatherapp.interactor;

/**
 * Created by cristiangomez on 14/10/15.
 */
public interface InteractorListener <L>
{

    void onSuccess (L response);

    void onFailure (Exception e);
}
