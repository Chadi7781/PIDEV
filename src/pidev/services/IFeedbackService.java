/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.ResultSet;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import pidev.entity.Feedback;
import pidev.entity.Reclamation;


/**
 *
 * @author PC
 */
public interface IFeedbackService {
    public void ajouterFeedback(Feedback p);  
    public ObservableList<Feedback> getAllFeedback();
    
    public void  traiterFeedback(Feedback p);
    
    public int getNbrFeedback();
    
   
 
    

    
}
