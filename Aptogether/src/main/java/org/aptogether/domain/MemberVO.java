package org.aptogether.domain;

import lombok.Data;

@Data
public class MemberVO {
   int memberSeq;
   String id;
   String password;
   int aptSeq;
   String dong;
   String ho;
   boolean admit;
   int type;
   String name;
}