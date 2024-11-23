import dev.program.Arena;
import dev.program.Dice.SixSidedDiceStrategy;
import dev.program.Player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    @Test
    void testPlayerCreation() {
        Player player = new Player("Test", 100, 10, 5);
        assertEquals("Test", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(5, player.getAttack());
    }

    @Test
    void testInvalidPlayerAttributes() {
        assertThrows(IllegalArgumentException.class,
                () -> new Player("Test", -1, 10, 5));
        assertThrows(IllegalArgumentException.class,
                () -> new Player("Test", 100, 0, 5));
        assertThrows(IllegalArgumentException.class,
                () -> new Player("Test", 100, 10, -5));
    }

    @Test
    void testPlayerHealth() {
        Player player = new Player("Test", 100, 10, 5);
        player.reduceHealth(30);
        assertEquals(70, player.getHealth());
        assertTrue(player.isAlive());

        player.reduceHealth(80);
        assertEquals(0, player.getHealth());
        assertFalse(player.isAlive());
    }

    @Test
    void testDiceRolls() {
        SixSidedDiceStrategy dice = new SixSidedDiceStrategy(6);
        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    void testArenaValidation() {
        Arena arena = new Arena();
        Player player = new Player("Test", 100, 10, 5);

        assertThrows(IllegalArgumentException.class,
                () -> arena.fight(null, player));
        assertThrows(IllegalArgumentException.class,
                () -> arena.fight(player, null));
    }
}
