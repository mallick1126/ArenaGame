
import dev.program.Action.Action;
import dev.program.Action.AttackAction;
import dev.program.Arena.Arena;
import dev.program.Dice.Dice;
import dev.program.Dice.SixSidedDiceStrategy;
import dev.program.Player.Player;
import dev.program.Player.PlayerBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    // Test for Player creation using Builder pattern
    @Test
    void testPlayerCreation() {
        Player player = new PlayerBuilder()
                .setName("TestPlayer")
                .health(100)
                .strength(20)
                .attack(15)
                .build();

        assertEquals("TestPlayer", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(20, player.getStrength());
        assertEquals(15, player.getAttack());
    }

    // Test for invalid Player attributes
    @Test
    void testInvalidPlayerAttributes() {
        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBuilder().setName("InvalidPlayer").health(-1).strength(10).attack(5).build());

        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBuilder().setName("InvalidPlayer").health(100).strength(0).attack(5).build());

        assertThrows(IllegalArgumentException.class,
                () -> new PlayerBuilder().setName("InvalidPlayer").health(100).strength(10).attack(-5).build());
    }

    // Test for Player health reduction
    @Test
    void testPlayerHealthReduction() {
        Player player = new PlayerBuilder()
                .setName("TestPlayer")
                .health(100)
                .strength(20)
                .attack(15)
                .build();

        player.reduceHealth(30);
        assertEquals(70, player.getHealth());

        player.reduceHealth(80);
        assertEquals(0, player.getHealth());
        assertFalse(player.isAlive());
    }

    // Test for Dice roll functionality
    @Test
    void testDiceRolls() {
        Dice dice = new Dice(new SixSidedDiceStrategy());

        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Dice roll out of range: " + roll);
        }
    }

    // Test for invalid Arena fight scenario
    @Test
    void testArenaFightValidation() {
        Player player = new PlayerBuilder()
                .setName("Player1")
                .health(100)
                .strength(20)
                .attack(15)
                .build();

        Arena arena = Arena.getInstance();
        assertThrows(IllegalArgumentException.class,
                () -> arena.fight(null, player, new AttackAction()));
        assertThrows(IllegalArgumentException.class,
                () -> arena.fight(player, null, new AttackAction()));
    }

    // Test for Arena fight and determine winner
    @Test
    void testArenaFight() {
        Player playerA = new PlayerBuilder()
                .setName("Player A")
                .health(100)
                .strength(20)
                .attack(15)
                .build();

        Player playerB = new PlayerBuilder()
                .setName("Player B")
                .health(80)
                .strength(25)
                .attack(10)
                .build();

        Arena arena = Arena.getInstance();
        Action attackAction = new AttackAction();

        // Run the fight and determine the winner
        Player winner = arena.fight(playerA, playerB, attackAction);

        // Test that the winner's health is greater than 0 and is not null
        assertNotNull(winner);
        assertTrue(winner.isAlive());
        assertEquals("Player A", winner.getName());  // Expected winner based on attributes
    }

    // Test for Singleton Arena instance
    @Test
    void testArenaSingleton() {
        Arena arena1 = Arena.getInstance();
        Arena arena2 = Arena.getInstance();

        // Assert that both instances are the same
        assertSame(arena1, arena2, "Arena instances should be the same");
    }
}
