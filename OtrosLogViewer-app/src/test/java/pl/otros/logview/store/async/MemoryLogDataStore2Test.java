package pl.otros.logview.store.async;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.Assert;
import pl.otros.logview.LogData;
import pl.otros.logview.LogDataBuilder;

import java.util.Date;

@Test(enabled=false)
public class MemoryLogDataStore2Test {
  @Test
  public void testFilter() throws Exception {
    //given
    MemoryLogDataStore2 logDataStore2 = new MemoryLogDataStore2();
    String[] messages = "Ala ma kota a kot ma ale".split(" ");
    LogData[] logDatas = new LogData[10000*messages.length];
    for (int i=0; i<logDatas.length;i++){
      LogData logData = new LogDataBuilder().withDate(new Date(100000l + i * 100)).withMessage(messages[i % messages.length]).build();
      logDatas[i]=logData;
    }
    logDataStore2.add(logDatas);

    //when
    FilterResult filterResult = logDataStore2.filter(new LogDataFilter("kot"));

    //then
    int filteredCount = logDataStore2.getCount();
    assertEquals(20000,filteredCount);
  }

  
  public void testSearch() throws Exception {
    Assert.fail("No implemented");
  }
}
