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
    private String preQuery;
    private String postQuery;

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
    
    public void setPreQuery(String preQuery) {
        this.preQuery = preQuery;
    }

    public void setPostQuery(String postQuery) {
        this.postQuery = postQuery;
    }

    public String getPreQuery() {
        return preQuery;
    }

    public String getPostQuery() {
        return postQuery;
    }
    
    public void setOpt(int opt, int selectedQuery) {
        this.opt = opt;
        
        
        switch(opt){
            
            case 0: this.setQuery(this.normalQ);
                    break;
            case 1: switch(selectedQuery){
                        case 1: this.setPreQuery("CALL preQuery1_Opt1();");
                                this.setQuery("SELECT hnum, street, brgy, mun, nbr, calam1_aid,dp_kit1, dp_kit1_xpiry, dp_kit2, dp_kit2_xpiry, dp_kit3, dp_kit4, dp_kit5, dp_kit6, dp_kit7, dp_kit8, dp_kit9\n" +
                                                "FROM hpq_hh_emergency_all\n" +
                                                "WHERE  calam1 = 1\n" +
                                                "GROUP BY mun, brgy;");
                                break;
                        case 2: this.setPreQuery("CALL preQuery2_Opt1();");
                                this.setQuery("SELECT *\n" +
                                                "FROM hpq_hh_calamity_house_all\n" +
                                                "WHERE calam1 = 1 OR calam2 = 1 OR calam4 = 1 OR calam6 = 1\n" +
                                                "GROUP BY mun,brgy;");
                                break;
                        case 3: this.setPreQuery("CALL preQuery3_Opt1();");
                                this.setQuery("SELECT mun, brgy, croptype, crop_vol\n" +
                                                "FROM hpq_hh_cropsurvive\n" +
                                                "WHERE calam3=1 \n" +
                                                "GROUP BY mun, brgy, croptype;");
                                break;
                        case 4: this.setPreQuery("CALL preQuery4_Opt1();");
                                this.setQuery("SELECT mun, gradel, COUNT(*)\n" +
                                                "FROM hpq_hh_hhmem\n" +
                                                "WHERE computer != 0 AND internet != 0 \n" +
                                                "GROUP BY mun, gradel");
                                break;
                        case 5: this.setPreQuery("CALL preQuery5_Opt1();");
                                this.setQuery("SELECT mun, aquanitype , aquaequiptype , MAX(aquani_vol) \n" +
                                                "FROM hpq_hh_fishequip\n" +
                                                "WHERE aquanitype IS NOT NULL\n" +
                                                "GROUP BY mun, aquanitype;");
                                break;
                        case 6: this.setPreQuery("CALL preQuery6_Opt1();");
                                this.setQuery("SELECT hpq_hh_id, croptype, alp_area, arcdp_mem_refno \n" +
                                                "FROM hpq_hh_crop_agarian_benefit\n" +
                                                "GROUP BY hpq_hh_id, croptype;");
                                break;
                        case 7: this.setPreQuery("CALL preQuery7_Opt1();");
                                this.setQuery("SELECT mdeady, COUNT(hpq_all_phiheal_mem.id) \n" +
                                                "FROM hpq_death, hpq_all_phiheal_mem\n" +
                                                "WHERE hpq_death.hpq_hh_id = hpq_all_phiheal_mem.hpq_hh_id AND hpq_death.id = hpq_all_phiheal_mem.id AND  mdeady IS NOT NULL\n" +
                                                "GROUP BY mdeady");
                                break;
                    }
                    break;
            case 2: switch(selectedQuery){
                        case 1: this.setPreQuery("CREATE INDEX mun_calam1_index ON hpq_hh(mun,calam1);");
                                this.setQuery(this.normalQ);
                                this.setPostQuery("DROP INDEX mun_calam1_index ON hpq_hh;");
                                break;
                        case 2: this.setPreQuery("CREATE INDEX calam_index ON hpq_hh(calam1,calam2,calam4,calam6)");
                                this.setQuery(this.normalQ);
                                this.setPostQuery("DROP INDEX calam_index ON hpq_hh;");
                                break;
                        case 3: this.setPreQuery("CREATE INDEX calam3_index ON hpq_hh(calam3);");
                                this.setQuery(this.normalQ);
                                this.setPostQuery("DROP INDEX calam3_index ON hpq_hh;");
                                break;
                        case 4: this.setPreQuery("CREATE INDEX ci_index ON hpq_hh(computer,internet);");
                                this.setQuery(this.normalQ);
                                this.setPostQuery("DROP INDEX ci_index ON hpq_hh;");
                                break;
                        case 5: this.setPreQuery("CREATE INDEX aquanitype_index ON hpq_aquani(aquanitype);");
                                this.setQuery(this.normalQ);
                                this.setPostQuery("DROP INDEX aquanitype_index ON hpq_aquani;");
                                break;
                        case 6: this.setQuery(this.normalQ);
                                break;
                        case 7: this.setQuery(this.normalQ);
                                break;
                    }
                    break;
            case 3: switch(selectedQuery){
                        case 1:this.setQuery("SELECT hnum, street, brgy, mun, nbr, calam1_aid,dp_kit1, dp_kit1_xpiry, dp_kit2, dp_kit2_xpiry, dp_kit3, dp_kit4, dp_kit5, dp_kit6, dp_kit7, dp_kit8, dp_kit9\n" +
                                            "FROM (SELECT id, hnum, street, brgy, mun, nbr, calam1\n" +
                                            "  FROM hpq_hh\n" +
                                            "  WHERE calam1 = 1\n" +
                                            "  GROUP BY mun, brgy)hpq_hh_address, \n" +
                                            "(SELECT id, calam1_aid,dp_kit1, dp_kit1_xpiry, dp_kit2, dp_kit2_xpiry, dp_kit3, dp_kit4, dp_kit5, dp_kit6, dp_kit7, dp_kit8, dp_kit9\n" +
                                            "  FROM hpq_hh \n" +
                                            "  WHERE calam1 = 1\n" +
                                            "  GROUP BY mun, brgy)hpq_hh_emergencykits\n" +
                                            "WHERE hpq_hh_address.id = hpq_hh_emergencykits.id;");
                                break;
                        case 2: this.setQuery("SELECT mun,brgy, house_type, roof, wall, calam1, calam2, calam4, calam6\n" +
                                                "FROM (SELECT id, mun,brgy, house_type, roof, wall\n" +
                                                "  FROM hpq_hh\n" +
                                                "  WHERE calam1 = 1 OR calam2 = 1 OR calam4 = 1 OR calam6 = 1 \n" +
                                                "  GROUP BY mun,brgy)hpq_hh_housestructure, \n" +
                                                "  (SELECT id, calam1, calam2, calam4, calam6\n" +
                                                "  FROM hpq_hh \n" +
                                                "  WHERE calam1 = 1 OR calam2 = 1 OR calam4 = 1 OR calam6 = 1 \n" +
                                                "  GROUP BY mun,brgy)hpq_hh_calamity\n" +
                                                "WHERE hpq_hh_housestructure.id = hpq_hh_calamity.id;");
                                break;
                        case 3: this.setQuery("SELECT mun, brgy, croptype, crop_vol  \n" +
                                                "FROM (SELECT mun,brgy, croptype, crop_vol\n" +
                                                " FROM hpq_hh, hpq_crop\n" +
                                                " WHERE hpq_hh.id = hpq_crop.hpq_hh_id AND calam3=1 \n" +
                                                " GROUP BY mun, croptype)hpq_hh_cropsurvive;");
                                break;
                        case 4: this.setQuery("SELECT mun, gradel, COUNT(*)\n" +
                                                "FROM (SELECT id,gradel\n" +
                                                "        FROM hpq_mem)hpq_studentswithci, \n" +
                                                "        (SELECT  id, mun\n" +
                                                "        FROM hpq_hh\n" +
                                                "    WHERE computer != 0 AND internet != 0)hpq_hh_mun\n" +
                                                "WHERE hpq_studentswithci.id = hpq_hh_mun.id\n" +
                                                "GROUP BY mun, gradel");
                                break;
                        case 5: this.setQuery("SELECT mun, FishType , EquipmentType , MAX(aquani_vol)  \n" +
                                                "FROM (SELECT mun, hpq_aquani.aquanitype AS 'FishType', hpq_aquaequip.aquaequiptype AS 'EquipmentType', hpq_aquani.aquani_vol\n" +
                                                "FROM hpq_hh, hpq_aquaequip, hpq_aquani\n" +
                                                "WHERE hpq_hh.id = hpq_aquaequip.hpq_hh_id AND hpq_hh.id = hpq_aquani.hpq_hh_id AND hpq_aquani.aquanitype IS NOT NULL)hpq_hh_fishequip\n" +
                                                "GROUP BY mun, FishType;");
                                break;
                        case 6: this.setQuery("SELECT hpq_hh_id, croptype, alp_area, arcdp_mem_refno FROM (SELECT hpq_crop.hpq_hh_id, croptype, alp_area, arcdp_mem_refno\n" +
                                                "FROM hpq_crop, hpq_alp, hpq_arcdp_mem\n" +
                                                "WHERE hpq_crop.hpq_hh_id = hpq_alp.hpq_hh_id AND hpq_alp.hpq_hh_id = hpq_arcdp_mem.hpq_hh_id\n" +
                                                "GROUP BY hpq_crop.hpq_hh_id, croptype)hpq_hh_crop_agarian_benefit;");
                                break;
                        case 7: this.setQuery("SELECT mdeady, COUNT(hpq_all_phiheal_mem.id) \n" +
                                                "FROM hpq_death,(SELECT hpq_hh_id, id \n" +
                                                "  FROM hpq_death\n" +
                                                "UNION \n" +
                                                "SELECT hpq_hh_id, id\n" +
                                                "  FROM hpq_phiheal_ofw_mem\n" +
                                                "UNION \n" +
                                                "SELECT hpq_hh_id, id\n" +
                                                "  FROM hpq_phiheal_empl_mem\n" +
                                                "UNION \n" +
                                                "SELECT hpq_hh_id, id\n" +
                                                "  FROM hpq_phiheal_indiv_mem\n" +
                                                "UNION \n" +
                                                "SELECT hpq_hh_id, id\n" +
                                                "  FROM hpq_phiheal_spon_mem\n" +
                                                "UNION \n" +
                                                "SELECT hpq_hh_id, id\n" +
                                                "  FROM hpq_phiheal_life_mem) hpq_all_phiheal_mem\n" +
                                                "WHERE hpq_death.hpq_hh_id = hpq_all_phiheal_mem.hpq_hh_id AND hpq_death.id = hpq_all_phiheal_mem.id AND  mdeady IS NOT NULL\n" +
                                                "GROUP BY mdeady;");
                                break;
                    }
                    break;  
        }
    }

    
    
    
            
            
    
}
