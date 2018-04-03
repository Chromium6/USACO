package genetic.alpha;

public class Nature {

    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.013;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    /* Public methods */
    
    // Evolve a population
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.getSize(), pop.getPerson(0).getSize(), false);

        // Keep our best individual
        if (elitism) {
            newPopulation.setPerson(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // crossover
        for (int i = elitismOffset; i < pop.getSize(); i++) {
            Person indiv1 = tournamentSelection(pop);
            Person indiv2 = tournamentSelection(pop);
            Person newIndiv = crossover(indiv1, indiv2);
            newPopulation.setPerson(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.getSize(); i++) {
            mutate(newPopulation.getPerson(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Person crossover(Person indiv1, Person indiv2) {
        Person newSol = new Person();
        newSol.setSize(indiv1.getSize());
        // Loop through genes
        for (int i = 0; i < indiv1.getSize(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    // Mutate an individual
    private static void mutate(Person indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.getSize(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // Select individuals for crossover
    private static Person tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, pop.getPerson(0).getSize(), false);
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.getSize());
            tournament.setPerson(i, pop.getPerson(randomId));
        }
        // Get the fittest
        Person fittest = tournament.getFittest();
        return fittest;
    }

}
