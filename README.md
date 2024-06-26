# Task 10: Refactoring (Rock-Paper-Scissors)
## Intellij - JUnit 5 - JaCoCoverage

### 1. Explore
Explore the code and it's logic. Add appropriate comments.
Take notes which details struck your eye first.
(What things are in need of cleaning up and refactoring)

#### Disclaimer: Some code snippets below represent ideas and suggestions. They are not the final code. Further refactoring was done after implementing said ideas.

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
### 2. Refactor
Refactor the code so that it aligns with OOP principles.
#### Pelaaja (Player) class
1. Made `pelaajanValinta()` shorter, simpler and better. See above.
2. Fixed `setVoitot()`. See above.
3. Renamed `setVoitot()` -> `lisääVoitto()` for clarity.
4. Made `int voitot` private to adhere to encapsulation.
#### Peli (Game) class
1. Variables:
   -  Removed `boolean peliLoppui`. Modified while loop to break when p1 or p2 has 3 wins.
   -  Removed `int p1Voitot`, `int p2Voitot`. Now check wins with `getVoitot()` instead.
   -  Moved player choice variables `String p1Valinta` & `String p2Valinta` inside the loop.
   -  Changed `int pelatutPelit = 0;` to -> `int erä = 1;`
2. Modified the do while loop:
   - ```java
     do {
            System.out.println("Erä: " + erä + " =====================\n");

            String p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta);
            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta);

            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli");
            } else if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
                    || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
                    || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
                p1.setVoitot();
                System.out.println("\n\tPelaaja 1 voittaa\n\tPelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            } else {
                p2.setVoitot();
                System.out.println("\n\tPelaaja 2 voittaa\n\tPelaaja 2:lla koossa " + p2.getVoitot() + " voittoa");
            }

            erä++; // erä pelattu

            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
                System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
                break;
            }
            System.out.println();
        } while (true);
     ```
     - added newlines, tabs, and overall re-organized it.

### 3. Testability
Take testability in to account. Further refactor the code. e.g move code in to their own methods.
Prepare JUnit 5 tests accordingly.

#### Refactor code to better serve testing
1. Detach some code in to their own methods.
    - Create `pelaa()`-method which houses the flow of the game.
    - Create `kukaVoitti()`-method to determine the winner.
    - Create `loppuikoPeli()` -method to check player's wins.
2. Create Test classes for both Peli and Pelaaja.
    - TestClasses.PeliTest.java
      - `setUp()`
      - `testPeli()`
    - TestClasses.PelaajaTest.java
      - `testLisääVoitto()`
      - `testPelaajanValinta()`
      - `testGetVoitotNone()`
      - `testGetVoitotYksi()`
      - `testGetVoitotKaksi()`
      - `testGetVoitotKolme()`
### 4. Javadoc
Add Javadoc comments to the methods and classes. Generate Javadoc HTML files. Push to repo.
Javadoc files can be found in the `root/src/javadocs` folder.

### 5. Java Code Coverage analysis
Finally, do a test coverage analysis. I used JaCoCo for this purpose.
#### Project Coverage
![Project Coverage](coverage/project_coverage.png)
#### Package Coverage
![Package Coverage](coverage/package_coverage.png)
#### Pelaaja Class Coverage
![Pelaaja Class Coverage](coverage/pelaaja_coverage.png)
#### Peli Class Coverage
![Peli Class Coverage](coverage/peli_coverage.png)
A few lines of code were not covered. Due to the nature of `tasapelit` variable in `kukaVoitti()`, it was decided to not test it.