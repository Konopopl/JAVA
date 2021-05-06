import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratorClientTest {

    @Test
    void generatorClientLegalEntiti() throws Exception {
        assertEquals(GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client.json").getClass().toString(), "class LegalEntity");
        LegalEntity legalEntity = (LegalEntity) GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client.json");
        assertEquals(legalEntity.getName(), "Maria");
        assertEquals(legalEntity.getInn(), 13242352);
        assertEquals(legalEntity.getClientType(), "LegalEntity");
        assertEquals(legalEntity.getIsSanctioned(), true);


        assertEquals(GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client.json").getClass().toString(), "class LegalEntity");
        LegalEntity legalEntity1 = (LegalEntity) GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client.json");
        assertEquals(legalEntity1.getName(), "Maria");
        assertEquals(legalEntity1.getInn(), 13242352);
        assertEquals(legalEntity1.getClientType(), "LegalEntity");
        assertEquals(legalEntity1.getIsSanctioned(), true);


    }

    @Test
    void generatorClientHolding() throws Exception {
        assertEquals(GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client1.json").getClass().toString(), "class Holding");
        Holding holding = (Holding) GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client1.json");
        assertEquals(holding.getName(), "ignaty");
        assertEquals(holding.getInn(), 100);
        assertEquals(holding.getSurname(), "Shatalovich");
        assertEquals(holding.getClientType(), "Holding");
        assertEquals(holding.getGender(), "man");


        assertEquals(GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client1.json").getClass().toString(), "class Holding");
        Holding holding1 = (Holding) GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client1.json");
        assertEquals(holding1.getName(), "ignaty");
        assertEquals(holding1.getInn(), 100);
        assertEquals(holding1.getSurname(), "Shatalovich");
        assertEquals(holding1.getClientType(), "Holding");
        assertEquals(holding1.getGender(), "man");

    }

    @Test
    void generatorClientIndividual() throws Exception {
        assertEquals(GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client2.json").getClass().toString(), "class Individual");
        Individual individual = (Individual) GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client2.json");
        assertEquals(individual.getName(), "Imenno");
        assertEquals(individual.getSurname(), "On");
        assertEquals(individual.getClientType(), "Individual");
        assertEquals(individual.getInn(), 1000);
        assertEquals(individual.getAge(), 100);

        assertEquals(GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client2.json").getClass().toString(), "class Individual");
        Individual individual1 = (Individual) GeneratorClient.GeneratorClientIf("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\client2.json");
        assertEquals(individual1.getName(), "Imenno");
        assertEquals(individual1.getSurname(), "On");
        assertEquals(individual1.getClientType(), "Individual");
        assertEquals(individual1.getInn(), 1000);
        assertEquals(individual1.getAge(), 100);


    }

    @Test
    void ExcemptionTest() { // аналогично проверяются все остальные исключения, если в файле не будет какого-то поля , то оно заполнится null в конструкторе и выдаст исключение

        Throwable expectedThrown = assertThrows(IllegalArgumentException.class, () -> {
            Individual individual = (Individual) GeneratorClient.GeneratorClientEnum("C:\\Users\\Pavlo\\IdeaProjects\\newhw1\\src\\main\\java\\clientExceptoon.json");

        });
        assertEquals(expectedThrown.getMessage(), "Error name");

    }
}