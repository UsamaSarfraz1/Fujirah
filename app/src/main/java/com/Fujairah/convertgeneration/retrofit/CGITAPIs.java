package com.Fujairah.convertgeneration.retrofit;


import com.Fujairah.convertgeneration.AttendanceModel.Root;
import com.Fujairah.convertgeneration.models.GeoLocationAttendance;
import com.Fujairah.convertgeneration.models.MarkAttendanceResponse;
import com.Fujairah.convertgeneration.models.attendance.AttendanceResponse;
import com.Fujairah.convertgeneration.models.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CGITAPIs {
    //http://developers.cgitsoft.com/QRV1/employee.php?action=login&email=admin&password=admin123
    @GET("QRV1//employee.php?action=login")
    Call<LoginResponse> getStudentResponse(@Query("email") String email, @Query("password") String password);

    //API to check attendance
    //http://developers.cgitsoft.com/QRV1/employee.php?action=view_attendance
    @GET("QRV1/employee.php?")
    Call<AttendanceResponse> getAttendance(@Query("action") String action);

    //API to get attendance by date range
    //http://developers.cgitsoft.com/QRV1/employee.php?action=view_attendance&from=2020-03-01&to=2020-03-31
    @GET("QRV1/employee.php?")
    Call<AttendanceResponse> getAttendanceByRange(@Query("action") String action,@Query("from")String from,
                                                  @Query("to")String to);

    //API to Mark attendance by Admin login
    //http://developers.cgitsoft.com/QRV1/employee.php?action=mark_attendance&emp_id=12&user_id=1
    @GET("QRV1/employee.php?")
    Call<MarkAttendanceResponse> markAttendance(@Query("action") String action, @Query("emp_id") String emp_id,
                                                @Query("user_id")String userId);

    //API to mark attendance by user (Geo Location API)
    //http://developers.cgitsoft.com/QRV1/employee.php?action=mark_attendance_geolocation&emp_id=16&lat=31.4178567&lon=73.0595913
    @GET("QRV1/employee.php?action=mark_attendance_geolocation")
    Call<GeoLocationAttendance> geoLocationAttendance(@Query("emp_id")String emp_id,
                                                      @Query("lat")String lat,
                                                      @Query("lon")String lng);
    //API to get attendance of specific user_id with date range
    //http://developers.cgitsoft.com/QRV1/employee.php?action=view_attendance&emp_id=14&from=2020-05-01&to=2020-06-02
    @GET("QRV1/employee.php?action=view_attendance")
    Call<Root> getAttendanceList(@Query("emp_id")String emp_id,
                                 @Query("from")String from,
                                 @Query("to")String to);

    //API to update profile data
    //http://developers.cgitsoft.com/QRV1/employee.php?action=update_profile&emp_id={emp_id}&name={inputname}&email={input email}&phone={input phone}&address={input address}&cnic={input cnic}&username={input usersname}
    @GET("QRV1/employee.php?action=update_profile")
    Call<com.Fujairah.convertgeneration.models.UpdateProfile.Root> UpdateProfile(@Query("emp_id")String emp_id,
                                                                                 @Query("name")String name,
                                                                                 @Query("email")String email,
                                                                                 @Query("phone")String phone,
                                                                                 @Query("address")String address,
                                                                                 @Query("cnic")String cnic,
                                                                                 @Query("username")String username);


    //API to reset password
    //http://developers.cgitsoft.com/QRV1/employee.php?action=reset_password&emp_id=35&password=123456
    @GET("QRV1/employee.php?action=reset_password")
    Call<com.Fujairah.convertgeneration.models.UpdateProfile.Root> resetPassword(@Query("emp_id") String emp_id,
                                                                                 @Query("password") String password);

}
