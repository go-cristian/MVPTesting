# MVP Testing in a nutshell

We are going to describe the process of how to create your custom implementation of MVP based on a test, think about this.

### Short story
* Write a test that satifies [this](https://github.com/iyubinest/MVPTesting/blob/master/app/src/test/java/co/iyubinest/weatherapp/WeatherPresenterTest.java) basic test.
* Write a [presenter](https://github.com/iyubinest/MVPTesting/blob/master/app/src/main/java/co/iyubinest/weatherapp/weather/ui/WeatherPresenter.java) that that handles the flow.
* Create a [view interface](https://github.com/iyubinest/MVPTesting/blob/master/app/src/main/java/co/iyubinest/weatherapp/weather/ui/WeatherView.java).
* write your custom data [provider](https://github.com/iyubinest/MVPTesting/blob/master/app/src/main/java/co/iyubinest/weatherapp/weather/repository/TestWeatherInteractor.java).

### Long story starts with a conversation

> Mr Director: "We need an application that fetch a list of items from a source (call it interweb), and then show them into a list".  
> Mr Developer: " Ok it looks that it's a work for an app".
> Mr Tech Director: "Hey make it testeable!" .
> Mr Developer: "Ok ... let me think about it..."

Well this is the story of our lives and almost everything in our software is kind of teateable, so in MVP the View is an object that uses the flow described in a presenter. If you have an Java Desktop App think about that the main class is your view and the main method starts using a Presenter.

### The dependencies
A presenter needs one or many or no sources that for me I called Interactors, also we have a related view (it can be any class so it`s normal to be an interface).

~~~java
@Mock
private WeatherView weatherView;

@Mock
private WeatherInteractor weatherInteractor;
~~~

### Argument captor to fire the responses
Another thing that we need is intercept the resonse from our interactor

~~~java
@Captor
private ArgumentCaptor<InteractorListener<List<Weather>>> callbackArgumentCaptor;
~~~

### Object References
add some references for our testing process

~~~java
private WeatherPresenter presenter;
private ArrayList<Weather> weatherData;
~~~

### Before our tests
prepare our tests is easy and mock some data:

~~~java
@Before
public void setUp() {
    MockitoAnnotations.initMocks(this);
    presenter = new WeatherPresenter(weatherInteractor);

    weatherData = new ArrayList<>();
    weatherData.add(new Weather("Bogotá", "13.2º", "Nublado"));
    weatherData.add(new Weather("Barranquilla", "43.2º", "Muy Cálido"));
}
~~~

### Workflow
test the flow for the sucessfull process

~~~java
@Test
public void testExecution() {
    presenter.onCreate(weatherView);
    verify(weatherInteractor, times(1)).getWeather(callbackArgumentCaptor.capture());
    callbackArgumentCaptor.getValue().onSuccess(weatherData);
    verify(weatherView, times(1)).load(weatherData);
}
~~~

### Your App here
now with this process you can create the classes that satifies this dependencies, for more information please review [this blogpost](https://medium.com/@iyubinest/testing-the-presenter-from-mvp-in-an-android-application-30d1e3fc41bb) at medium.

Also if you want to check my approach you can see it ah this repo, also you can use whatever you want for getting responses like AsyncTasks, Retrofit, RxAndroid, or even a ThreadPool ... so it's up to you to give a check of how to decouple your ui from the source of your information and how to check your flow even if you dont want to have instrumentation tests in your app.
