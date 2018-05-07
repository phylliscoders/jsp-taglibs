# jsp-taglibs
Useful JSP Custom taglibs for Korean

## Get Started

```java
<%@ taglib uri="https://phylliscoders.github.io/jsp/tlds/pc" prefix="pc"%>
```

## TODO

- [v] number format general
- [v] number to hangeul
- [ ] security ssn
- [ ] security name
- [ ] security phone number
- [ ] security tel number
- [ ] security number only
- [ ] security ip address
- [ ] ln2br
- [ ] escape

## Number Format

### general
```java
<pc:numberFormat number="100050.574" format="#,###.00"/>
// 100,050.57
```

### number to hangeul
```java
<pc:numberToHangeul number="12345" cc="N" />
// 일만이천삼백사십오

<pc:numberToHangeul number="12345" cc="Y" />
// 一萬二千三百四十五
```

## Security Format

### ssn
```java
<pc:secSsn value="9001011009807" />
// 900101-1******
```

### name
```java
<pc:secName value="홍길동" />
// 홍*동
```

### phone number
```java
<pc:secPhone value="01011121113" />
// 010-****-1113

<pc:secPhone value="010-1112-1113" />
// 010-****-1113
```

### tel number
```java
<pc:secTel value="023335555" />
// 02-333-****

<pc:secTel value="02-333-5555" />
// 02-333-****
```

### number only
```java
<pc:secNo value="서대문구 거북골로 33" />
// 서대문구 거북골로 **
```

### ip address
```java
<pc:secIp value="192.168.0.1" />
// 192.168.***.***
```

## ln2br

## escape

