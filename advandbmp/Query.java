/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advandbmp;

/**
 *
 * @author LUCKY
 */
public class Query {
    private String description;
    private String defenition;
    private String query;
    private long execTime;
    int opt;
    private String normalQ;

    public Query(String description, String defenition, String query, long execTime, int opt) // temporary CNSTRUCTOR
    {
        this.description = description;
        this.defenition = defenition;
        this.query = query;
        this.execTime = execTime;
        this.opt = opt;
        this.normalQ = query;
    }

    public String getDefenition()
    {
        return defenition;
    }

    public void setDefenition(String defenition)
    {
        this.defenition = defenition;
    }
    
    
    public Query(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getOpt() {
        return opt;
    }

    public long getExecTime() {
        return execTime;
    }

    public void setExecTime(long execTime) {
        this.execTime = execTime;
    }
    
  
    //gets the table used in the query
    public void getTables()
    {
        String tables;
    }
    
    public void createIndex()
    {
        
    }
    
    public void setOpt(int opt, int selectedQuery) {
        this.opt = opt;
        
        
        switch(opt){
            
            case 0: this.setQuery(normalQ);
                    break;
            case 1: //optimization 1 - redesign table by splitting the tables used -- getTables()
                    break;
            case 2: //optimization 2 - create seconday indexes for columns searched -- createIndex()
                    break;
            case 3: this.setQuery("SELECT alp_line FROM hpq_alp");
                    break;
            case 4: //optimization 4
                    break;   
        }
    }

    
    
    
            
            
    
}
