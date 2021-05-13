/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacaion2.Controllers;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ni.edu.uni.fcys.programacion2.backend.pojo.Empleado;
import ni.uni.edu.fcys.programacion2.Frame.SalarioCalculator;

/**
 *
 * @author JADPA02
 */

public class SalarioController {
    private SalarioCalculator calculator;
    private String [] Columns={"Nombres","Apellido","Fecha","SalarioBruto",
        "Inss","IR","Antiguedad","SalarioNeto"};
    private DefaultTableModel tablaempleado;
    private List<Empleado>empleado ;

    public SalarioController(SalarioCalculator calculator) {
        this.calculator = calculator;
        initComponent();
    }

    private void initComponent() {
        tablaempleado=new DefaultTableModel(null,Columns);
        calculator.getTblEmpleado().setModel(tablaempleado);
        
        calculator.getBtnAgregar().addActionListener(((e) -> {
               btnAgregarActionPerformed(e);
            }));
    }
    
    private void btnAgregarActionPerformed(ActionEvent e){
        String nombres,apellidos,fecha_contratacion,salarioporhora,HorasTra,comision;
        double salarioBruto,inss,IR,SalarioNeto;
        
        nombres=calculator.getTxtNombres().getText();
        apellidos=calculator.getTxtApellidos().getText();
        fecha_contratacion=calculator.getTxtFecha().getText();
        salarioporhora=calculator.getTxtSalHor().getText();
        HorasTra=calculator.getTxtHoTra().getText();
        comision=calculator.getTxtComision().getText();
        salarioBruto=calcSalarioBruto();
        inss=INSS();
        IR=IR();
        SalarioNeto=SalarioNeto();
        
        Empleado em=new Empleado(nombres, apellidos, fecha_contratacion, salarioporhora, HorasTra, comision, salarioBruto, inss, IR, SalarioNeto, SalarioNeto);
        
        
    }
    
    public double calcSalarioBruto(){
        double SalaHo= Double.parseDouble(calculator.getTxtSalHor().getText());
        double HorTra= Double.parseDouble(calculator.getTxtHoTra().getText());
        double comision= Double.parseDouble(calculator.getTxtComision().getText());
        
        return SalaHo*(HorTra+comision);
    }
    
    public double INSS(){
        double salaB= calcSalarioBruto();
        
        return salaB*0.07;
    }
    
    public double salarioAnual(){
        double salB=calcSalarioBruto();
        double inss=INSS();
        
        return (salB-inss)*12;
    }
    
    public double IR(){
        double salaA=salarioAnual();
        double ir =0;
        
        if(salaA>=0.01 || salaA<=100000){
            ir=salaA;
        }else if(salaA>=100001 || salaA<=200000){
            ir=((((salaA-100000)*0.15)+0)/12);
        }else if(salaA>=200001 || salaA<=350000){
            ir=((((salaA-200000)*0.20)+15000)/12);
        }else if(salaA>=350001 || salaA<=500000){
            ir=((((salaA-350000)*0.25)+45000)/12);
        }else if(salaA>=500001){
            ir=((((salaA-500000)*0.30)+82500)/12);
        }
        
        return ir;
    }
    
    public double SalarioNeto(){
        double SB=calcSalarioBruto();
        double IN=INSS();
        double IR=IR();
        
        return SB-IN-IR;    
    }
}
