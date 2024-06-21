package com.ibeifeng.sparkproject.test;

import com.ibeifeng.sparkproject.util.StringUtils;

public class SessionAggrStatAccumulatorTest {

    public static void main(String[] args) {
        String v1 = "aaa=1|ccc=1";
        String v2 = "aaa=1|bbb=1|ccc=1||ddd=1";

        SessionAggrStatAccumulatorTest aaaTest =
                new SessionAggrStatAccumulatorTest();
        System.out.println(aaaTest.add(v1, v2));


    }

    /**
     * session统计计算逻辑
     * @param v1 连接串
     * @param v2 范围区间
     * @return 更新以后的连接串
     */
    private String add(String v1, String v2) {
        // 校验：v1为空的话，直接返回v2
        if(StringUtils.isEmpty(v1)) {
            return v2;
        }

        // 使用StringUtils工具类，从v1中，提取v2对应的值，并累加1
        String oldValue = StringUtils.getFieldFromConcatString(v1, "\\|", v2);
        if(oldValue != null) {
            // 将范围区间原有的值，累加1
            int newValue = Integer.valueOf(oldValue) + 1;
            // 使用StringUtils工具类，将v1中，v2对应的值，设置成新的累加后的值
            return StringUtils.setFieldInConcatString(v1, "\\|", v2, String.valueOf(newValue));
        }

        return v1;
    }
}
