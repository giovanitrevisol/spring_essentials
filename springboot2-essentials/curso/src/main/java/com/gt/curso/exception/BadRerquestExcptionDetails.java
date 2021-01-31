package com.gt.curso.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class BadRerquestExcptionDetails extends ExceptionDetails {
}
