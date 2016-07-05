package myServiceClasses;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;

public class MyCapabilityMatcher extends DefaultCapabilityMatcher {
   private final String crazyNodeName = "crazyNodeName";
   @Override
   public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {
      boolean basicChecks = super.matches(nodeCapability, requestedCapability);
      if (! requestedCapability.containsKey(crazyNodeName)){
         //If the user didnt set the custom capability lets just return what the DefaultCapabilityMatcher
         //would return. That way we are backward compatibility and arent breaking the default behavior of the
         //grid
         return basicChecks;
      }
      return (basicChecks && nodeCapability.get(crazyNodeName).equals(requestedCapability.get(crazyNodeName)));
   }
}
