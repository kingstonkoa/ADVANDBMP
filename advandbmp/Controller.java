/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandbmp;

import advandbmp.ADVANDB_MP;
import advandbmp.MyPanel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kingston
 */
public class Controller
{
    private ADVANDB_MP mp;
    private Database db;
    private ArrayList<Query> queryList = new ArrayList<>();
    private MyPanel mainPanel;

    public Controller() {
        db = new Database();
       
    }
    
    public void setMP(ADVANDB_MP mp)
    {
        this.mp = mp;
    }

    public void DisplayResultPanel(String query)
    {
       ResultPanel rp = new ResultPanel(this);
       
       Query q = new Query("Desc");
       q.setQuery(query);
        
       ResultSet rs = db.execQuery(q);
       rp.myModel(rs);//pass result set to result panel
       
       mp.setPanel(rp);
    }
    
    public long DisplayExecTime(String query)
    {
       Query q = new Query("Desc");
       q.setQuery(query);
        
       long execTime = db.execTime(q);
       return execTime;
       
    }
    public void goBack()
    {
        mp.setPanel(mainPanel);
    }
    
    public void setMainPanel(MyPanel myPanel)
    {
        this.mainPanel = myPanel;
    }

    public ArrayList<Query> getQueries()
    {
        Query q1 = new Query("QUERY 1", 
                            "SELECT hnum, street, brgy, mun, nbr, calam1_aid,dp_kit1, dp_kit1_xpiry, dp_kit2, dp_kit2_xpiry, dp_kit3, dp_kit4, dp_kit5, dp_kit6, dp_kit7, dp_kit8, dp_kit9\n" +
                            "FROM hpq_hh\n" +
                            "WHERE calam1 = 1\n" +
                            "GROUP BY mun,brgy", 
                            0, 
                            0);
        Query q2 = new Query("QUERY 2", 
                             "SELECT mun,brgy, house_type, roof, wall, calam1, calam2, calam4, calam6\n" +
                             "FROM hpq_hh\n" +
                             "WHERE calam1 = 1 OR calam2 = 1 OR calam4 = 1 OR calam6 = 1 \n" +
                             "GROUP BY mun,brgy", 
                             0,
                             0);
        Query q3 = new Query("QUERY 3", 
                             "SELECT mun, brgy, croptype, crop_vol, COUNT(*)\n" +
                             "FROM hpq_hh, hpq_crop\n" +
                             "WHERE hpq_hh.id = hpq_crop.hpq_hh_id AND calam3=1\n" +
                             "GROUP BY mun, croptype",
                              0,
                              0);
        Query q4 = new Query("QUERY 4", 
                             "SELECT mun, gradel, COUNT(*)\n" +
                             "FROM hpq_hh, hpq_mem\n" +
                             "WHERE hpq_hh.id = hpq_mem.id AND computer != 0 AND internet != 0 \n" +
                             "GROUP BY mun, gradel",
                              0,
                              0);
        Query q5 = new Query("QUERY 5", 
                             "No query yet",
                              0,
                              0);
        Query q6 = new Query("QUERY 6", 
                             "SELECT hpq_crop.hpq_hh_id, croptype, alp_area, arcdp_mem_refno\n" +
                             "FROM hpq_crop, hpq_alp, hpq_arcdp_mem\n" +
                             "WHERE hpq_crop.hpq_hh_id = hpq_alp.hpq_hh_id AND hpq_alp.hpq_hh_id = hpq_arcdp_mem.hpq_hh_id\n" +
                             "GROUP BY hpq_crop.hpq_hh_id, croptype",
                              0,
                              0);
        Query q7 = new Query("QUERY 7", 
                             "No query yet",
                              0,
                              0);
        queryList.add(q1);
        queryList.add(q2);
        queryList.add(q3);
        queryList.add(q4);
        queryList.add(q5);
        queryList.add(q6);
        queryList.add(q7);
        
        return this.queryList;
    }
    
    public ArrayList<Query> getDummyQueries() // DUMMY
    {
        Query q1 = new Query("DESCRIPTION 1", 
                "SELECT hnum, street, brgy, mun, nbr, calam1_aid,dp_kit1, dp_kit1_xpiry, dp_kit2, dp_kit2_xpiry, dp_kit3, dp_kit4, dp_kit5, dp_kit6, dp_kit7, dp_kit8, dp_kit9\n" +
                "FROM hpq_hh\n" +
                "WHERE calam1 = 1\n" +
                "GROUP BY mun,brgy", 
                10, 
                0);
        Query q2 = new Query("DESCRIPTION 2", 
                             "SELECT mun,brgy, house_type, roof, wall, calam1, calam2, calam4, calam6\n" +
                             "FROM hpq_hh\n" +
                             "WHERE calam1 = 1 OR calam2 = 1 OR calam4 = 1 OR calam6 = 1 \n" +
                             "GROUP BY mun,brgy", 
                             20,
                             0);
        Query q3 = new Query("DESCRIPTION 3", "SELECT 3", 30, 0);
        
        queryList.add(q1);
        queryList.add(q2);
        queryList.add(q3);
        
        return this.queryList;
    }
}
