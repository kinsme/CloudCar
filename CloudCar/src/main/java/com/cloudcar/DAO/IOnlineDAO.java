package com.cloudcar.DAO;

/**
 * Created by Administrator on 2016/6/17.
 */
public interface IOnlineDAO {
     boolean findBySerialnumber(String serialnumber);
     void setOnline(String serialnumber);
     void setOffline(String serialnumber);
}
