package steps;


//import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.HomePageActions;
import utils.SeleniumDriver;

public class HomePageSteps {

	HomePageActions homePageActions = new HomePageActions();

	@Given("^Phileas is on the Home Page \"([^\"]*)\" of Trip Planner Website$")
	public void i_am_on_the_Home_Page_of_CarsGuide_Website(String webSiteURL) {
		SeleniumDriver.openPage(webSiteURL);

	}
	

	@When("^he executes a trip plan from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void he_executes_a_trip_plan_from_to(String fromStation,
			String toStation) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		homePageActions.setFromAndToStation(fromStation, toStation);
		homePageActions.clickGoButton();
		Thread.sleep(5000);

	}

	@Then("^a list of trips should be provided$")
	public void a_list_of_trips_should_be_provided() {
		
		homePageActions.verifyResultList();

	}

	@When("^he selects \"([^\"]*)\" station in From station$")
	public void he_selects_station_in_From_station(String fromStation) {
		
		homePageActions.setFromStation(fromStation);

	}

	@When("^he selects \"([^\"]*)\" station in To station$")
	public void he_selects_station_in_To_station(String toStation) {
		
		homePageActions.setToStation(toStation);

	}

	@When("^he clicks Go Button$")
	public void he_clicks_Go_Button() {
		
		homePageActions.clickGoButton();
	}

}
