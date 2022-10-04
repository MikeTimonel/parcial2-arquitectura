package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;

class BuyTest {

  private Database database;
  private final Buy service = new Buy(database);

  @Test
  public void test() {
    service.makePurchase(2, 3, "Books");
  }

}