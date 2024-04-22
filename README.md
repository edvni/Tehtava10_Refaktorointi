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
   - One can simplify the method. Instead of selecting "kivi", "paperi", or "sakset", use an array of choices and return one randomly.
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
#### Pelaaja (Player) class
