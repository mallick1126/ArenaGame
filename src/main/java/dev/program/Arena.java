package dev.program;

public class Arena {
    private final Dice dice;

    public Arena(){
        this.dice = new Dice(6);
    }

    public Player fight(Player player1, Player player2){
        if(player1 == null || player2 == null){
            throw new IllegalArgumentException("Both the players must be non-null");
        }
        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while(player1.isAlive() && player2.isAlive()){
            processTurn(attacker, defender);

            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        return player1.isAlive() ? player1 : player2;
    }

    private void processTurn(Player attacker, Player defender) {
    }


}
