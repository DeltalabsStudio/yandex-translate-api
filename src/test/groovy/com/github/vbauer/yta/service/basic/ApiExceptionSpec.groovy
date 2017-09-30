package com.github.vbauer.yta.service.basic

import com.github.vbauer.yta.service.basic.exception.ApiException
import spock.lang.Specification

/**
 * Tests for {@link com.github.vbauer.yta.service.basic.exception.ApiException}.
 *
 * @author Vladislav Bauer
 */

class ApiExceptionSpec extends Specification {

    def "Check inheritance"() {
        expect:
            RuntimeException.isAssignableFrom(ApiException)
    }

    def "Check construction"() {
        expect:
            def ex = new ApiException(status)
            assert ex.toString().contains(String.valueOf(status))
            assert ex.getStatus() == status
        where:
            status << [
                ApiStatus.ERR_KEY_INVALID,
                ApiStatus.ERR_KEY_BLOCKED,
                ApiStatus.ERR_DAILY_REQ_LIMIT_EXCEEDED,
                ApiStatus.ERR_DAILY_CHAR_LIMIT_EXCEEDED,
                ApiStatus.ERR_TEXT_TOO_LONG,
                ApiStatus.ERR_UNPROCESSABLE_TEXT,
                ApiStatus.ERR_LANG_NOT_SUPPORTED
            ]
    }

}
