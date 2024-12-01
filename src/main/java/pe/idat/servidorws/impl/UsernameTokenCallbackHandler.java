package pe.idat.servidorws.impl;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

@Component
public class UsernameTokenCallbackHandler implements CallbackHandler {

  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    for (Callback callback : callbacks) {
      if (callback instanceof WSPasswordCallback) {
        WSPasswordCallback pc = (WSPasswordCallback) callback;
        if ("admin".equals(pc.getIdentifier())) {
          pc.setPassword("pwd123");
        }
      } else {
        throw new UnsupportedCallbackException(callback, "Unsupported callback type");
      }
    }
  }
}