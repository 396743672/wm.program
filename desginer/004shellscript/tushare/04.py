# -*- coding:utf-8 -*-
# Author: ycg000344
# 股票分类数据

from sqlalchemy import create_engine
import tushare as ts

engine = create_engine('mysql://admin:Admin123!@www.wm.org:3306/stockquotation?charset=UTF8')

# 401
# 行业分类
# 返回值说明
# code：股票代码
# name：股票名称
# c_name：行业名称
df = ts.get_industry_classified()
df.to_sql('t_industry_classified',engine)

# 402
# 概念分类
# 返回值说明
# code：股票代码
# name：股票名称
# c_name：行业名称
df = ts.get_concept_classified()
df.to_sql('t_concept_classified',engine)

# 403
# 地域分类
# 返回值说明
# code：股票代码
# name：股票名称
# c_name：行业名称
df = ts.get_area_classified()
df.to_sql('t_area_classified',engine)

# 404
# 中小板分类
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_sme_classified()
df.to_sql('t_sme_classified',engine)

# 405
# 创业板分类
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_gem_classified()
df.to_sql('t_gem_classified',engine)

# 406
# 风险警示板分类
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_st_classified()
df.to_sql('t_st_classified',engine)

# 407
# 沪深300成份及权重
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_hs300s()
df.to_sql('t_hs300s',engine)

# 408
# 上证50成份股
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_sz50s()
df.to_sql('t_sz50s',engine)

#409
# 中证500成份股
# 返回值说明
# code：股票代码
# name：股票名称
df = ts.get_zz500s()
df.to_sql('t_zz500s',engine)

# 410
# 终止上市股票列表
# 返回值说明
# code：股票代码
# name：股票名称
# oDate:上市日期
# tDate:终止上市日期
df = ts.get_terminated()
df.to_sql('t_terminated',engine)

# 411
# 暂停上市股票列表
# 返回值说明
# code：股票代码
# name：股票名称
# oDate:上市日期
# tDate:终止上市日期
df = ts.get_suspended()
df.to_sql('t_suspended',engine)