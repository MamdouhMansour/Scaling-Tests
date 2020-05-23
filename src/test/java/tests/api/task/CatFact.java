package tests.api.task;

import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionType;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class CatFact {

    @Test(description = "TC001 - Check text is not empty ")
    @Description("Check that text in the response body is not empty in the random fact")
    @Severity(SeverityLevel.NORMAL)
    public void testCatFactResponse() {

	RestActions apiObject = new RestActions("https://cat-fact.herokuapp.com");

	// using random to get random cat fact, amount = 1 to get only one fact.
	Response facts = apiObject.performRequest(RequestType.GET, 200, "/facts/random?amount=1");

	boolean isTextEmpty = RestActions.getResponseJSONValue(facts, "text").isEmpty();

	Assertions.assertTrue(isTextEmpty, AssertionType.NEGATIVE, "Text Is Not Empty");
    }
}
