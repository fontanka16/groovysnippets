import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by Theodor on 2015-10-20.
 */
class YearValidator {
    @Before
    public void setUp() throws Exception {
        println "Set Up"
    }
    @After
    public void tearDown() throws Exception{
        println "Tear Down"
    }

    @Test
    public void testMacth(){
        assert ("1881" ==~ /\d*/)
        assert !("fyra" ==~ /\d*/)
    }

    @Test
    public  void isNull(){
        def result =  Validators.YearValidator.validateYear(null);
        assert result.result == false;
    }
    @Test
    public  void isEmpty(){
        def result =  Validators.YearValidator.validateYear("");
        assert result.result == false;
    }

    @Test
    public  void isWhiteSpace(){
        def result =  Validators.YearValidator.validateYear(" ");
        assert result.result == false;
    }

    @Test
    public  void isAlphaString(){
        def result =  Validators.YearValidator.validateYear("fyra");
        assert result.result == false;
    }
    @Test
    public  void isTooLong(){
        def result =  Validators.YearValidator.validateYear("18881");
        assert result.result == false;
    }
    @Test
    public  void isTooShort(){
        def result =  Validators.YearValidator.validateYear("181");
        assert result.result == false;
    }
    @Test
    public  void isRight(){
        def result =  Validators.YearValidator.validateYear("1881");
        assert result.result == true;
        assert result.value == 1881;
    }


}
