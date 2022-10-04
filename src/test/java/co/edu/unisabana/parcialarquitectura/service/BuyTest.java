package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BuyTest {

  @Mock
  private Database database;
  @Mock
  private IllegalSaleException illegalSaleException;

  @InjectMocks
  private final Buy service = new Buy(database);

  @Test
  public void Given_data_book_When_makePurchase_Then_Product_sold() {
    Mockito.when(database.savePurchase(3,"Books")).thenReturn(1);
    String advice = service.makePurchase(2, 3, "Books");
    assertEquals("Product sold", advice);
  }

  @Test
  public void Given_data_book_When_makePurchase_Then_failed_sell() {
    Mockito.when(database.savePurchase(0,"Books")).thenReturn(0);
    String advice = service.makePurchase(2, 0, "Books");
    assertEquals("The sale was not possible", advice);
  }
}