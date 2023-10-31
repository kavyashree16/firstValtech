package corejava;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cssProject {
	
    public static void main(String[] args, Object newParam) {
    	
        try {
            String fileName = "C:\\Users\\KavyashreeR\\valtech2023\\corejava\\src\\corejava\\NewFile.css"; // Replace with your CSS file path
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder cssContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                cssContent.append(line).append("\n");
            }
            br.close();
            
            // Define regular expressions for class selectors, int attributes, and hex color attributes
            Pattern classSelectorPattern = classSelectorRegexandPttern();

            Pattern intAttributePattern = attributeRegexandPattern();
            
            Pattern hexColorAttributePattern = hexcolourAttributeRegexandPattern();


            
            // Compile the regular expressions
            
            // Match and extract class selectors and attributes
            matcherClassinsideAttributeinsideHexcolorAttri_Matcher(cssContent, classSelectorPattern,
					intAttributePattern, hexColorAttributePattern);
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
	/**
	 * @param cssContent
	 * @param classSelectorPattern
	 * @param intAttributePattern
	 * @param hexColorAttributePattern
	 * 
	 * 
	 */
    
   // matcherClassinsideAttributeinsideHexcolorAttri_Matcher
	public static void  matcherClassinsideAttributeinsideHexcolorAttri_Matcher(StringBuilder cssContent,
			Pattern classSelectorPattern, Pattern intAttributePattern, Pattern hexColorAttributePattern) {
		gettingClassSelectorMatcher(cssContent, classSelectorPattern, intAttributePattern, hexColorAttributePattern);
	}
	
	
	
	
	
	public static void gettingClassSelectorMatcher(StringBuilder cssContent, Pattern classSelectorPattern,
			Pattern intAttributePattern, Pattern hexColorAttributePattern) {
		Matcher classSelectorMatcher = classSelectorPattern.matcher(cssContent);
		while (classSelectorMatcher.find()) {
			String classContent = allAboutClassSelectorMatcher(cssContent, intAttributePattern, classSelectorMatcher);
		    hexColorAttributeMatcher(hexColorAttributePattern, classContent);
		}
	}
	public static String allAboutClassSelectorMatcher(StringBuilder cssContent, Pattern intAttributePattern,
			Matcher classSelectorMatcher) {
		String classSelector = classSelectorMatcher.group(1);
				    System.out.println("Class Selector: " + classSelector);
				    // Now, within the class selector, search for int attributes and hex color attributes
				    int startIndex = classSelectorMatcher.end();
				    int endIndex = cssContent.indexOf("}", startIndex);
				    String classContent = cssContent.substring(startIndex, endIndex);
				    Matcher intAttributeMatcher = intAttributePattern.matcher(classContent);
				    while (intAttributeMatcher.find()) {
				    	allAboutAttribute(intAttributeMatcher);
				    }
		return classContent;
	}
	public static void allAboutAttribute(Matcher intAttributeMatcher) {
		String attributeName = intAttributeMatcher.group(1);
		int attributeValue = Integer.parseInt(intAttributeMatcher.group(2));
				        System.out.println("Int Attribute: " + attributeName + " = " + attributeValue);
	}
	
	
	
	public static void hexColorAttributeMatcher(Pattern hexColorAttributePattern, String classContent) {
		Matcher hexColorAttributeMatcher = hexColorAttributePattern.matcher(classContent);
		while (hexColorAttributeMatcher.find()) {
			String attributeName = hexColorAttributeMatcher.group(1);
			String hexValue = hexColorAttributeMatcher.group(2);
		    String rgbValue = hexToRgb(hexValue);
		    System.out.println("Hex Color Attribute: " + attributeName + " = " + rgbValue);
		}
	}
	public static Pattern hexcolourAttributeRegexandPattern() {
		String hexColorAttributeRegex = "([a-zA-Z-]+)\\s*:\\s*#([0-9a-fA-F]+);";
		Pattern hexColorAttributePattern = Pattern.compile(hexColorAttributeRegex);
		return hexColorAttributePattern;
	}
	public static Pattern attributeRegexandPattern() {
		String intAttributeRegex = "([a-zA-Z-]+)\\s*:\\s*([0-9]+);";
		Pattern intAttributePattern = Pattern.compile(intAttributeRegex);
		return intAttributePattern;
	}
	public static Pattern classSelectorRegexandPttern() {
		String classSelectorRegex = "\\.([a-zA-Z0-9_-]+)\\s*\\{";
		Pattern classSelectorPattern = Pattern.compile(classSelectorRegex);
		return classSelectorPattern;
	}
    public static String hexToRgb(String hex) {
        int colorValue = Integer.parseInt(hex, 16);
        int red = (colorValue >> 16) & 0xFF;
        int green = (colorValue >> 8) & 0xFF;
        int blue = colorValue & 0xFF;
        return "rgb(" + red + "," + green + "," + blue + ")";
    }
}