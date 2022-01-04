package com.unifacef.rentalapi.utils;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.unifacef.rentalapi.exceptions.MessageKey;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageUtils {

  private final MessageSource messageSource;

  public String getMessage(final MessageKey messageKey, final Object... param) {
    return messageSource.getMessage(messageKey.getKey(), param, getLocale());
  }
}