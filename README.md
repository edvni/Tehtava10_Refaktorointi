# Task 10: Refactoring (Rock-Paper-Scissors)
## Intellij - JUnit 5 - JaCoCoverage

### 1. Explore
Explore the code and it's logic. Add appropriate comments.
Take notes which details struck your eye first.
(What things are in need of cleaning up and refactoring)

#### Pelaaja (Player) class
1. Variable naming:
    - `voitotYhteensä` is redundant. `voitot` already keeps track of total wins.
2. Redundant Variable in `setVoitot()`:
    - No need for `voitotYhteensä`. One can directly increment `voitot` instead.
3. Improve `pelaajanValinta()`:
   - We can simplify the method. Instead of selecting "kivi", "paperi", or "sakset", use an array of choices and return one randomly.
   ```java
   public class Pelaaja() {
        int voitot;
   
        public String pelaajanValinta() {
            String[] valinnat = {"kivi", "paperi", "sakset"};
            Random rand = new Random();
            int index = random.nextInt(valinnat.length);
            return valinnat[index];
        }
   
        public void setVoitot() {
            voitot++;
        }
   
        public int getVoitot() {
            return voitot;
        }    
   }
   ```
#### Peli (Game) class
   1. Redundant declaration:
      ```java
      boolean peliLoppui = false; // redundant
      
      !(p1.getVoitot() >= 3 || p2.getVoitot() >= 3) // can use this instead
      ```
   2. Redundant variables:
      ```java
      int p1Voitot = p1.voitot;       // redundant
      int p2Voitot = p2.voitot;       // redundant
      
      p1.getVoitot()    // use instead
      p2.getVoitot()    // use instead
      ```
   3. Simplify win condition:
      - Instead of handling each combination, we can determine the winner based on the choices of both players.
      ```java
      if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
      } else if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
              || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
              || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
            p1.setVoitot();
            System.out.println("Pelaaja 1 voittaa");
      } else {
            p2.setVoitot();
            System.out.println("Pelaaja 2 voittaa");
      }
      ```