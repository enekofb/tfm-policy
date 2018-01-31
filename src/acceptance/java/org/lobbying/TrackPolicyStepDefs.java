package org.lobbying;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.common.CommonLobbyingStepDefs;
import org.lobbying.policy.dto.PolicyDTO;
import org.lobbying.utils.client.PolicyClient;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

public class TrackPolicyStepDefs extends CommonLobbyingStepDefs{

    private CitizenDTO citizenDTO;

    private PolicyDTO policyDTO;

    @MockBean
    private PolicyClient policyClient;

    @Before
    public void setup(){
    }


    @Given("^the citizen is interested on the policy$")
    public void theCitizenIsInterestedOnThePolicy() throws Throwable {
        citizenDTO = getPolicyWorld().getCitizenDTO();
        assertThat(citizenDTO,is(notNullValue()));
        policyDTO = getPolicyWorld().getPolicyDTO();
        assertThat(policyDTO,is(notNullValue()));
    }



    @When("^citizen tracks the policy$")
    public void citizenTracksThePolicy() throws Throwable {
        boolean tracked = getPolicyWorld().citizenTrackPolicy(citizenDTO.getId(),policyDTO.getId());
        assertThat(policyDTO,is(notNullValue()));
    }

    @Then("^the policy has been tracked$")
    public void thePolicyHasBeenTracked() throws Throwable {
        boolean policyTracked = getPolicyWorld()
                .isCitizenTrackingPolicyById(citizenDTO.getId(),policyDTO.getId());
        assertEquals(policyTracked, true);
    }
}
