/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.fcys.programacion2.backend.pojo;

/**
 *
 * @author JADPA02
 */
public class Empleado {

    String id,nombres,apellidos,fecha_contratacion,salarioporhora;
    String HorasTra,Comision;
    double salariobruto,inss,ir,antiguedad,salarioneto;
    
    public Empleado(String id, String nombres, String apellidos, String fecha_contratacion, String salarioporhora) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_contratacion = fecha_contratacion;
        this.salarioporhora = salarioporhora;
    }

    public Empleado() {
    }

    public Empleado(String nombres, String apellidos, String fecha_contratacion, String salarioporhora, String HorasTra, String Comision, double salariobruto, double inss, double ir, double antiguedad, double salarioneto) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_contratacion = fecha_contratacion;
        this.salarioporhora = salarioporhora;
        this.HorasTra = HorasTra;
        this.Comision = Comision;
        this.salariobruto = salariobruto;
        this.inss = inss;
        this.ir = ir;
        this.antiguedad = antiguedad;
        this.salarioneto = salarioneto;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getSalarioporhora() {
        return salarioporhora;
    }

    public void setSalarioporhora(String salarioporhora) {
        this.salarioporhora = salarioporhora;
    }
    
    
}
