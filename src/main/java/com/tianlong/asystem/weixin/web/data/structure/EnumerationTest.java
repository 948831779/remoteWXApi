package com.tianlong.asystem.weixin.web.data.structure;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: asystem
 * @description: Enumeration数据结构
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-15 08:38
 *
 *         序号	            方法描述
 *         1	boolean hasMoreElements( )       测试此枚举是否包含更多的元素。
 *         2	Object nextElement( )            如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
 **/

public class EnumerationTest {
    public static void main(String[] args) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<String>(10);
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println("121    "+days.nextElement());
        }
    }

}
