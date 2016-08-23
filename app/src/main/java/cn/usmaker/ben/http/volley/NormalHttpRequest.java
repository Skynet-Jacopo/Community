package cn.usmaker.ben.http.volley;

/**
 * Created by chenzhenyang on 2016/1/14.
 */

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by chenzhenyang on 2015/6/21.
 */
public class NormalHttpRequest extends Request<JSONObject> {

    private Map<String, String> mMap;
    private Map mHeaders = new HashMap(1);

    public static String sessionID = null;

    private Response.Listener<JSONObject> mListener;

    public NormalHttpRequest(String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, Map<String, String> map) {
        super(Request.Method.POST, url, errorListener);

        mListener = listener;
        mMap = map;
    }

    //mMap是已经按照前面的方式,设置了参数的实例
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mMap;
    }

    //此处因为response返回值需要json数据,和JsonObjectRequest类一样即可
    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            Map<String, String> headers = response.headers;
            String              cookie  = headers.get("Set-Cookie");
            if (cookie != null) {
                sessionID = cookie;
                //sessionID = cookie.substring(0, cookie.indexOf(";"));// 获取sessionID
            }
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        mListener.onResponse(response);
    }

    @Override
    public Map getHeaders() throws AuthFailureError {
        if (sessionID != null) {
            mHeaders.put("Cookie", sessionID);
        }
        return mHeaders;
    }

    /**
     * 清除Session,退出时调用
     */
    public static void clearSession() {
        sessionID = null;
    }

}