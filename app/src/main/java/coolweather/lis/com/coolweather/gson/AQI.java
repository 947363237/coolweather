package coolweather.lis.com.coolweather.gson;

/**
 * Created by Administrator on 2017/9/13 0013.
 */

public class AQI {
    private AQICity city;

    public class AQICity {
        private String aqi;
        private String pm25;

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }
    }

    public AQICity getCity() {
        return city;
    }

    public void setCity(AQICity city) {
        this.city = city;
    }
}