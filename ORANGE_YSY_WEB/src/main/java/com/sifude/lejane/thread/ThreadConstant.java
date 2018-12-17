package com.sifude.lejane.thread;


/**
 * <pre>
 * 读/写动态数据库 决策者
 * 根据DataSourceType是write/read 来决定是使用读/写数据库
 * 通过ThreadLocal绑定实现选择功能
 * </pre>
 * @author Zhang Kaitao
 *
 */
public class ThreadConstant {
    
    public enum DataSourceType {
        write, read;
    }
    
    
    private static final ThreadLocal<DataSourceType> holder = new ThreadLocal<DataSourceType>();
    private static final ThreadLocal<String> safetyId = new ThreadLocal<String>();
    
    public static void markWrite() {
        holder.set(DataSourceType.write);
    }
    
    public static void markRead() {
        holder.set(DataSourceType.read);
    }
    
    public static void reset() {
        holder.set(null);
    }
    
    public static boolean isChoiceNone() {
        return null == holder.get(); 
    }
    
    public static boolean isChoiceWrite() {
        return DataSourceType.write == holder.get();
    }
    
    public static boolean isChoiceRead() {
        return DataSourceType.read == holder.get();
    }
    
    public static String getSafetyId() {
    	return safetyId.get();
    }
    
    public static void setSafetyId(String safetyId) {
    	ThreadConstant.safetyId.set(safetyId);
    }
    
    public static boolean isNullSafetyId () {
    	return null == safetyId.get();
    }
}
