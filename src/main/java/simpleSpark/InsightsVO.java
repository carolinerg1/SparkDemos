package simpleSpark;

import java.io.Serializable;

import java.util.UUID;



public class InsightsVO implements Serializable {
    
    
    
    //private static final long serialVersionUID = 2042131405032412445L;
    
    
    
    private String deviceUuid;
    
    
    
    private String recordDate;
    
    
    
    private String insightCategory;
    
    
    
    private String activityType;
    
    
    
    private String insight_Id;
    
    
    
    private int minsSpent;
    
    
    
    
    
    public String getRecordDate() {
        
        return recordDate;
        
    }
    
    
    
    public void setRecordDate(String recordDate) {
        
        this.recordDate = recordDate;
        
    }
    
    
    
    public String getInsightCategory() {
        
        return insightCategory;
        
    }
    
    
    
    public void setInsightCategory(String insightCategory) {
        
        this.insightCategory = insightCategory;
        
    }
    
    
    
    public String getActivityType() {
        
        return activityType;
        
    }
    
    
    
    public void setActivityType(String activityType) {
        
        this.activityType = activityType;
        
    }
    
    
    
    public String getDeviceUuid() {
        
        return deviceUuid;
        
    }
    
    
    
    public void setDeviceUuid(String deviceUuid) {
        
        this.deviceUuid = deviceUuid;
        
    }
    
    
    
    public int getMinsSpent() {
        
        return minsSpent;
        
    }
    
    
    
    public void setMinsSpent(int minsSpent) {
        
        this.minsSpent = minsSpent;
        
    }
    
    
    
    public String getInsight_Id() {
        
        return insight_Id;
        
    }
    
    
    
    public void setInsight_Id(String insight_Id) {
        
        this.insight_Id = insight_Id;
        
    }
    
    
    
    @Override
    
    public String toString() {
        
        return "InsightsVO [deviceUuid=" + deviceUuid + ", recordDate=" + recordDate + ", insightCategory=" + insightCategory + ", activityType=" + activityType + ", insight_Id=" + insight_Id + ", minsSpent=" + minsSpent + "]";
        
    }
    
    
    
    
    
    
    
}
