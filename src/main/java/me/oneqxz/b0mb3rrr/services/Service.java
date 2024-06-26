package me.oneqxz.b0mb3rrr.services;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import me.oneqxz.b0mb3rrr.Config;
import me.oneqxz.b0mb3rrr.data.Phone;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.Proxy;
import java.util.Locale;

import static java.lang.StringTemplate.STR;

@Getter(AccessLevel.PROTECTED)
@Log4j2
public abstract class Service implements IService {

    private final Faker faker = new Faker(Locale.of("RU"));

    public String getName()
    {
        return faker.name().fullName();
    }

    public String getEmail()
    {
        return STR."\{this.getLogin()}@gmail.com";
    }

    public String getLogin()
    {
        return STR."\{RandomStringUtils.random(3, "ABCDEFGHIKLMNOPQRSTVXYZ")}\{RandomStringUtils.random(3, "abcdefghiklmnopqrstvxyz")}\{System.currentTimeMillis() * 1000}";
    }

    public void execute(Config config)
    {
        Request request = this.buildRequest(config.getPhone())
                .addHeader("User-Agent", faker.internet().userAgentAny())
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .build();

        @Nullable Proxy proxy = null;
        if(config.getProxys() != null)
        {
            me.oneqxz.b0mb3rrr.data.proxy.Proxy s = config.getProxys().getRandomProxy();
            if(s != null)
                proxy = s.toJavaProxy();
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(proxy)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                log.error(STR."Неверный код состояния для сервиса \{this.getServiceName()} \{response.code()}\{config.isDebug() ? STR.": \{response.body().string().replace("\n", " ")}" : ""}");

            else
                log.info(STR."Сервис \{this.getServiceName()} отправил код успешно");
        } catch (IOException e) {
            log.fatal(new RuntimeException(e));
        }
    }
}
