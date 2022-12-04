package football;

import org.junit.Before;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class FootballTeamTests {
    private static final int VACANT_POSITION = 12;
    private static final String PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "test Name";

    private Footballer footballer;
    private FootballTeam footballTeam;
    private String name;

    //we create base set up
    @Before
    public void setUp(){
        this.footballer = new Footballer(PLAYER_NAME);

        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITION );
    }

    //two test for team position
    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoPosition(){
        new FootballTeam(TEAM_NAME, -1);
    }

    @Test
    public void testCreatingTeamWithActualPositionShouldSetCorrectPositionCount(){
        assertEquals(VACANT_POSITION, footballTeam.getVacantPositions());
    }

    //three test for NAME
    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail(){
        new FootballTeam(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail(){
        new FootballTeam(" ", 1);
    }

    @Test
    public void testCreatingTeamWithNameShouldCreateTheTeam(){
        assertEquals(TEAM_NAME, footballTeam.getName());
    }

    // testing addPlayer with two tests
    @Test
    public void testAddingPlayerShouldIncreaseTeamMemberCount(){
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerShouldFailWhenTeamIsFull(){
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);

        team.addFootballer(footballer);
    }

    //test RemovingPlayer
    @Test
    public void testRemoveFootballerShouldReduceTeamCount(){
        footballTeam.addFootballer(footballer);

        assertEquals(1, footballTeam.getCount());

        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldFailWhenNoSuchPlayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Not_added");
    }

    //test footballer for sale
    @Test
    public void testFootballerForSaleShouldDeactivatedPlayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldFailIfPlayerIsMissing(){
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Not_added");
    }


}

