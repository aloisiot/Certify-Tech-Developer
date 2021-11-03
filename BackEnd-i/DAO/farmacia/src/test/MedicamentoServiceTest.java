package test;

import configurations.DBConnection;
import impl.MedicamentoDaoH2;
import models.Medicamento;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import services.MedicamentoService;

import java.sql.SQLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new DBConnection()));

    @Test
    public void salvarMedicamentoTest() throws SQLException {
        Medicamento medicamento = new Medicamento( 10, "ibuprofeno", "laboratotrio123", 19.9);
        medicamentoService.salvar(medicamento);
        Assert.assertNotNull(medicamento);

    }

    @Test
    public void buscarPorIdTest() throws SQLException {
        Medicamento medicamento = medicamentoService.buscar(1);
        Assert.assertNotNull(medicamento);
    }
}
