package Data;

import java.util.HashMap;
import java.util.List;

public class TestTarget {
    String targetName;
    List<Number> groupId;
    List<String> expectedGroupPermission;

    public TestTarget(String targetName, List<Number> groupId, List<String> expectedGroupPermission){
        this.targetName = targetName;
        this.groupId = groupId;
        this.expectedGroupPermission = expectedGroupPermission;
    }

    private void setTargetName(String targetName) {
        this.targetName = targetName;
    }
    private void setGroupId(List<Number> groupId) {
        this.groupId = groupId;
    }
    private void setExpectedGroupPermission(List<String> expectedGroupPermission){
        this.expectedGroupPermission = expectedGroupPermission;
    }
    private String getTargetName(){
        return this.targetName;
    }
    private List<Number> getGroupId(){
        return this.groupId;
    }
    private List<String>  getExpectedGroupPermission(){
        return this.expectedGroupPermission;
    }
}
